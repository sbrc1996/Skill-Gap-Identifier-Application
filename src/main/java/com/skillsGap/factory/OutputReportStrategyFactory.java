package com.skillsGap.factory;

import com.skillsGap.outputs.*;

public class OutputReportStrategyFactory {
    public static SkillGapReportStrategy getStrategy(OutputType type,String outputPath){
        return switch (type){
            case CONSOLE -> new ConsoleOutputStrategy();
            case CSV -> new CSVOutputStrategy(outputPath);
            case PDF -> new PdfOutputStrategy(outputPath);
        };
    }
}
