package ua.edu.sumdu.j2se.sholokhDanil.tasks;

import java.util.Scanner;

public class Task {

    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean tusk_active;
    private boolean repeat;


    //неактивну задачу, яка виконується у заданий час без повторення із заданою назвою
    public void Task(String title, int time)
    {
        this.title = title;
        this.time = time;
        tusk_active = false;
        repeat = false;
    }

    //неактивну задачу, яка виконується у заданому проміжку часу (і початок і кінець включно) із
    //заданим інтервалом і має задану назву
    public void Task(String title, int start, int end, int interval)
    {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        tusk_active = false;
        repeat = false;
    }

    // get set
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isActive()
    {
        return tusk_active;
    }

    public void setActive(boolean tusk_active)
    {
        this.tusk_active = tusk_active;
    }

    //  якщо задача повторюється метод має повертати час початку
    //повторення
    public int getTime()
    {
        if (repeat)
        {
            return start;
        }

        return 0;
    }

    //якщо задача повторювалась, вона має стати такою,
    //що не повторюється
    public void setTime(int time)
    {
        if (repeat)
        {
            repeat = false;
        }
    }

    //якщо задача не повторюється метод має повертати час
    //виконання задачі
    public int getStartTime()
    {
        if (!repeat)
        {
            return start;
        }

        return 0;
    }

    //якщо задача не повторюється метод має повертати час
    //виконання задачі
    public int getEndTime()
    {
        if (!repeat)
        {
            return end;
        }
        return 0;
    }

    //якщо задача не повторюється метод має
    //повертати 0
    public int getRepeatInterval()
    {
        if (!repeat)
        {
            return 0;
        }

        return 1;
    }

    //якщо задача не
    //повторювалася метод має стати такою, що повторюється
    void setTime(int start, int end, int interval)
    {
        if (!repeat)
        {
            repeat = true;
        }
    }

    //Метод для перевірки повторюваності задач
    public boolean isRepeated()
    {
        return repeat;
    }


    public int nextTimeAfter(int current)
    {
        if (current > end)
        {
            if (tusk_active && repeat)
            {
                int nextStart = end + interval;
                return nextStart;
            }
        }

        if (current < end)
        {
            return start;
        }

        return 0;
    }
}
