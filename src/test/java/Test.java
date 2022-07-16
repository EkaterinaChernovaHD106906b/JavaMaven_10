import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Game;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Test {
    Player first = new Player(89, "Ivan", 67);
    Player second = new Player(02, "Denis", 90);
    Player third = new Player(55, "Svetlana", 72);
    Player fourth = new Player(31, "Oleg", 120);
    Player fifth = new Player(41, "Olga", 100);
    Player sixth = new Player(90, "Oksana", 100);


    @org.junit.jupiter.api.Test
    public void myTest() {
        List<Player> players = new ArrayList<>();
        players.add(first);
        players.add(second);
        int actual = players.size();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void myTest2() {
        Game game = new Game();
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fifth);
        int actual = game.findName("Denis");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void myTest3() {
        Game game = new Game();
        game.register(first);
        game.register(second);
        game.register(third);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Olga");
        });


    }

    @org.junit.jupiter.api.Test
    public void myTest4() {
        Game game = new Game();
        game.register(first);
        game.register(second);
        int actual = game.round("Ivan", "Denis");
        int expected = 2;
        Assertions.assertEquals(actual, expected);

    }

    @org.junit.jupiter.api.Test
    public void myTest5() {
        Game game = new Game();
        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Olga");
        });


    }

    @org.junit.jupiter.api.Test
    public void myTest6() {
        Game game = new Game();
        game.register(fifth);
        game.register(sixth);
        int actual = game.round("Olga", "Oksana");
        int expected = 0;
        Assertions.assertEquals(actual, expected);

    }

    @org.junit.jupiter.api.Test
    public void myTest7() {
        Game game = new Game();
        game.register(second);
        game.register(first);
        int actual = game.round("Denis", "Ivan");
        int expected = 1;
        Assertions.assertEquals(actual, expected);

    }

    @org.junit.jupiter.api.Test
    public void myTest8() {
        Game game = new Game();
        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oksana", "Denis");
        });


    }


}



