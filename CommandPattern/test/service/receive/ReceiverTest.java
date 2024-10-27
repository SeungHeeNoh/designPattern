package service.receive;

import domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static service.receive.Receiver.*;

class ReceiverTest {

    private Player player;
    private Receiver receiver;

    @BeforeEach
    void setUp() {
        player = Mockito.spy(new Player("wizard"));
        receiver = Mockito.spy(new Receiver(player));
    }

    @Test
    void givenWalkId_whenExecuteCommand_thenCallWalkMethod() {
        // given
        int param = WALK_COMMAND_ID;

        // when
        receiver.executeCommand(param);

        // then
        verify(receiver).executeCommand(param);
        verify(player).walk();
    }

    @Test
    void givenJumpId_whenExecuteCommand_thenCallJumpMethod() {
        // given
        int param = JUMP_COMMAND_ID;

        // when
        receiver.executeCommand(param);

        // then
        verify(receiver).executeCommand(param);
        verify(player).jump();
    }

    @Test
    void givenRunId_whenExecuteCommand_thenCallRunMethod() {
        // given
        int param = RUN_COMMAND_ID;

        // when
        receiver.executeCommand(param);

        // then
        verify(receiver).executeCommand(param);
        verify(player).run();
    }

    @Test
    void givenDashId_whenExecuteCommand_thenCallDashMethod() {
        // given
        int param = DASH_COMMAND_ID;

        // when
        receiver.executeCommand(param);

        // then
        verify(receiver).executeCommand(param);
        verify(player).dash();
    }

    @Test
    void givenFlyId_whenExecuteCommand_thenCallFlyMethod() {
        // given
        int param = FLY_COMMAND_ID;

        // when
        receiver.executeCommand(param);

        // then
        verify(receiver).executeCommand(param);
        verify(player).fly();
    }

    @Test
    void givenWalkIdAndExperience_whenExecuteCommand_thenCallFlyMethod() {
        // given
        int param = WALK_COMMAND_ID;

        // when
        receiver.executeCommand(param);
        player.adjustExp(7000);
        receiver.executeCommand(param);

        // then
        verify(receiver, times(2)).executeCommand(param);
        verify(player, times(2)).walk();
    }
}