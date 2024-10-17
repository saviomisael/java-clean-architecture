package br.com.alura.codechella.shared.mapper;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public class Mapper {
    public <I, O> O map(I input, Class<O> target, Map<String, String> bindings) throws RuntimeException {
        try {
            Class<?> clazz = input.getClass();

            O instance = target.getDeclaredConstructor().newInstance();

            Field[] clazzFields = clazz.getDeclaredFields();
            Field[] targetFields = target.getDeclaredFields();

            Arrays.stream(clazzFields).forEach(clazzField -> {
                Arrays.stream(targetFields).forEach(targetField -> {
                    clazzField.setAccessible(true);
                    targetField.setAccessible(true);

                    String fieldBinding = bindings.getOrDefault(clazzField.getName(), null);

                    if(targetField.getName().equals(fieldBinding) && clazzField.getType().equals(targetField.getType())) {
                        try {
                            targetField.set(instance, clazzField.get(input));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            });

            return instance;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
