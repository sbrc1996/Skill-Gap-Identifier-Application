package com.skillsGap.observers.recommendation.consumer;

import com.skillsGap.pojos.Skill;
import com.skillsGap.pojos.SkillGapReport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OllamaRecomendation implements RecommendationObserver {
    @Override
    public void notify(SkillGapReport report) {
        System.out.println("\n Recommendation for User: " + report.getUserId());

        StringBuilder sb = new StringBuilder();

        if (report.getMissingSkills().isEmpty() && report.getWeakSkills().isEmpty()) {
            System.out.println(" You meet all required skills, no courses for u!");
            return;
        }
        if (!report.getMissingSkills().isEmpty()) {
            for (Skill skill : report.getMissingSkills()) {
                sb.append(skill.getSkillName()).append(", ");
            }
        }
        if (!report.getWeakSkills().isEmpty()) {
            for (Skill skill : report.getWeakSkills()) {
                sb.append(skill.getSkillName()).append(", ");
            }
        }
        String modelName = "gemma3:1b";
        String promptText = "Mention 1 course for each of the skills mentioned here: "+sb.toString()+" Give the name and URL only please.";

        try{
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            String requestBody = """
            {
              "model": "%s",
              "prompt": "%s",
              "stream": false
            }""".formatted(modelName, promptText);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(requestBody.getBytes());
            }
            // Read response
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {

                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            }
            // Extract only AI response
            String json = response.toString();
            String aiResponse = json.split("\"response\":\"")[1].split("\"")[0];
            // Console output
            System.out.println("AI Recommendation for user:"+report.getUserId());
            System.out.println(aiResponse);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
