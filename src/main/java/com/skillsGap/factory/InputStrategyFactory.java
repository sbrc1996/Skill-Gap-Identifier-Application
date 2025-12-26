package com.skillsGap.factory;

import com.skillsGap.inputs.*;


public class InputStrategyFactory {
    public static InputStrategy getStrategy(InputType type){
        return switch (type){
            case CSV -> new CSVInputStrategy();
            case XML -> new XmlInputStrategy();
            case JSON -> new JsonInputStrategy();
            default -> throw new IllegalArgumentException("Wrong type of Input reading!!!");
        };
    }
}
