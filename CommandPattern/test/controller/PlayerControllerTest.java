package controller;

import domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static controller.PlayerController.*;

class PlayerControllerTest {

    private Player player;
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        player = Mockito.spy(new Player("wizard"));
        playerController = Mockito.spy(new PlayerController(player));
    }

    @Test
    void givenWalkId_whenExecuteCommand_thenCallWalkMethod() {
        // given
        int param = WALK_COMMAND_ID;

        // when
        playerController.executeCommand(param);

        // then
        verify(playerController).executeCommand(param);
        verify(player).walk();
    }

    @Test
    void givenJumpId_whenExecuteCommand_thenCallJumpMethod() {
        // given
        int param = JUMP_COMMAND_ID;

        // when
        playerController.executeCommand(param);

        // then
        verify(playerController).executeCommand(param);
        verify(player).jump();
    }

    @Test
    void givenRunId_whenExecuteCommand_thenCallRunMethod() {
        // given
        int param = RUN_COMMAND_ID;

        // when
        playerController.executeCommand(param);

        // then
        verify(playerController).executeCommand(param);
        verify(player).run();
    }

    @Test
    void givenDashId_whenExecuteCommand_thenCallDashMethod() {
        // given
        int param = DASH_COMMAND_ID;

        // when
        playerController.executeCommand(param);

        // then
        verify(playerController).executeCommand(param);
        verify(player).dash();
    }

    @Test
    void givenFlyId_whenExecuteCommand_thenCallFlyMethod() {
        // given
        int param = FLY_COMMAND_ID;

        // when
        playerController.executeCommand(param);

        // then
        verify(playerController).executeCommand(param);
        verify(player).fly();
    }

    @Test
    void givenWalkIdAndExperience_whenExecuteCommand_thenCallFlyMethod() {
        // given
        int param = WALK_COMMAND_ID;

        // when
        playerController.executeCommand(param);
        player.adjustExp(7000);
        playerController.executeCommand(param);

        // then
        verify(playerController, times(2)).executeCommand(param);
        verify(player, times(2)).walk();
    }
}