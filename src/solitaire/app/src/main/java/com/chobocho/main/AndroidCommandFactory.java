package com.chobocho.main;
import com.chobocho.command.CommandFactory;
import com.chobocho.main.cmd.WinEndCommandFactoryStateImpl;
import com.chobocho.main.cmd.WinIdleCommandFactoryStateImpl;
import com.chobocho.main.cmd.WinPauseCommandFactoryStateImpl;
import com.chobocho.main.cmd.WinPlayCommandFactoryStateImpl;

public class AndroidCommandFactory extends CommandFactory {

    public AndroidCommandFactory() {
        idleState = new WinIdleCommandFactoryStateImpl();
        playState = new WinPlayCommandFactoryStateImpl();
        pauseState = new WinPauseCommandFactoryStateImpl();
        endState = new WinEndCommandFactoryStateImpl();
    }

}