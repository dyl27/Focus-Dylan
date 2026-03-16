package com.example.focus;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskManager
 * Clase encargada de gestionar una lista de tareas sugeridas.
 * Implementa operaciones CRUD sobre una colección de tareas.
 */
public class TaskManager {

    // Lista que almacena las tareas
    private List<String> tasks;

    /**
     * Constructor que inicializa la lista de tareas
     */
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    /**
     * CREATE
     * Agrega una nueva tarea a la lista
     */
    public void addTask(String task) {
        tasks.add(task);
    }

    /**
     * READ
     * Devuelve la lista de tareas
     */
    public List<String> getTasks() {
        return tasks;
    }

    /**
     * UPDATE
     * Modifica una tarea existente
     */
    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
        }
    }

    /**
     * DELETE
     * Elimina una tarea de la lista
     */
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}