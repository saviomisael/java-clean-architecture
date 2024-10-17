package br.com.alura.codechella.application.usecases;

public interface IUseCase<I extends IUseCase.Input, O extends IUseCase.Output> {
    O handle(I input);

    public interface Input {}
    public interface Output {}
}
