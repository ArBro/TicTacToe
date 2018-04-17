package nl.arbro.tictactoe.model;

import java.util.regex.Pattern;

/**
 * Created By: arbro
 * Date: 13-4-18 - 15:20
 * Project: tictactoe
 **/

public class WinPatternFactory {
    public static Pattern getPattern(BoardGameType boardGameType){
        switch (boardGameType){
            case TICTACTOE: {
                return Pattern.compile(".*([^-])\\1{2,}.*");
            }
            case CONNECT_FOUR: {
                return Pattern.compile(".*([^-])\\1{3,}.*");
            }
            default: return null;
        }
    }
}