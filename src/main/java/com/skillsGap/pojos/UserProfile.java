package com.skillsGap.pojos;

public class UserProfile {
    private String id;
    private String name;
    private String currentRole;
    private String certifications;
    private int experience;

    public UserProfile(String id, String name, String currentRole, String certifications, int experience) {
        this.id = id;
        this.name = name;
        this.currentRole = currentRole;
        this.certifications = certifications;
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public String getCertifications() {
        return certifications;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", currentRole='" + currentRole + '\'' +
                ", certifications='" + certifications + '\'' +
                ", experience=" + experience +
                '}';
    }
}
