package io.github.kmakma.scotlandyardhelper;

import de.dikodam.skotlindyard.api.Move;
import org.jetbrains.annotations.Nullable;

public class Movement {

    private int which;
    private int imageButtonResID;
    private Move move = null;

    public Movement(int which, int imageButtonResID) {
        this.which = which;
        this.imageButtonResID = imageButtonResID;
    }

    public int getWhich() {
        return which;
    }

    public int getImageButtonResID() {
        return imageButtonResID;
    }

    @Nullable
    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
