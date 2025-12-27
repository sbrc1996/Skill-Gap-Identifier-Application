package com.skillsGap.inputs;

import com.skillsGap.pojos.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVInputStrategy implements InputStrategy{
    @Override
    public List<UserProfile> readUsers(String filePath) {
        List<UserProfile> userProfileList = new ArrayList<>();
        try{
            File csv = new File(filePath);
            if(csv.exists()){
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String line;
                int count = 0;

                while((line = br.readLine()) != null){
                    if(count == 0){
                        count++;
                        continue;
                    }

                    String[] data = line.split(",");
                    String id = data[0];
                    String name = data[1];
                    String currentRole = data[2];
                    String certifications = data[3];
                    int experience = Integer.parseInt(data[4]);
                    UserProfile userProfile = new UserProfile(id,name,currentRole,certifications,experience);
                    userProfileList.add(userProfile);
                    count++;
                }
                System.out.println("Total records read: "+userProfileList.size());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userProfileList;
    }

    @Override
    public List<Skill> readSkills(String filePath) {
        List<Skill> skillList = new ArrayList<>();
        try{
            File csv = new File(filePath);
            if(csv.exists()){
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String line;
                int count = 0;

                while((line = br.readLine()) != null){
                    if(count == 0){
                        count++;
                        continue;
                    }

                    String[] data = line.split(",");
                    String id = data[0];
                    String name = data[1];
                    String category = data[2];
                    Skill skill = new Skill(id,name,category);
                    skillList.add(skill);
                    count++;
                }
                System.out.println("Total records read: "+skillList.size());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return skillList;
    }

    @Override
    public List<UserProfileSkill> readUserProfileSkills(String filePath) {
        List<UserProfileSkill> userProfileSkillList = new ArrayList<>();
        try{
            File csv = new File(filePath);
            if(csv.exists()){
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String line;
                int count = 0;

                while((line = br.readLine()) != null){
                    if(count == 0){
                        count++;
                        continue;
                    }

                    String[] data = line.split(",");
                    String userId = data[0].trim();
                    String skillId = data[1].trim();
                    Proficiency proficiency = Proficiency.valueOf(data[2].trim().toUpperCase());
                    UserProfileSkill ups = new UserProfileSkill(userId,skillId,proficiency);
                    userProfileSkillList.add(ups);
                    count++;
                }
                System.out.println("Total records read: "+userProfileSkillList.size());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userProfileSkillList;
    }

    @Override
    public List<ExpectedSkill> readExpectedSkills(String filepath) {
        List<ExpectedSkill> expectedSkillList = new ArrayList<>();
        try{
            File csv = new File(filepath);
            if(csv.exists()){
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String line;
                int count = 0;

                while((line = br.readLine()) != null){
                    if(count == 0){
                        count++;
                        continue;
                    }

                    String[] data = line.split(",");
                    String id = data[0];
                    String name = data[1];
                    String category = data[2];
                    Proficiency level = Proficiency.valueOf(data[3].trim().toUpperCase());
                    ExpectedSkill skill = new ExpectedSkill(id,name,category,level);
                    expectedSkillList.add(skill);
                    count++;
                }
                System.out.println("Total records read: "+expectedSkillList.size());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return expectedSkillList;
    }
}
