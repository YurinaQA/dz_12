package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean expected = true;
        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);

    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean expected = true;
        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);

    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(1);

        boolean expected = false;
        boolean actual = task.matches("Домой");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Позвонить домой", "Написать - маме", "Отправить - папе"};
        Task epic = new Epic(1, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Написать маме");

        Assertions.assertEquals(expected, actual);
    }


}