package org.example;

import org.example.Repository.ImobiliariaRepository;
import org.example.Service.ImobiliariaService;

public class Main {
    public static void main(String[] args) {
        ImobiliariaRepository imobiliariaRepository = new ImobiliariaRepository();
        ImobiliariaService imobiliariaService = new ImobiliariaService(imobiliariaRepository);
        MenuConsole menuMain = new MenuConsole(imobiliariaService);

        menuMain.menu();
    }
}