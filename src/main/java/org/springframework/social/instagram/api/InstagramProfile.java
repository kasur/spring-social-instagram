package org.springframework.social.instagram.api;

/**
 *
 * Model class representing a Media object in Instagram (essentially this is a pivot object)
 *
 * @author erusak.
 */
public class InstagramProfile extends InstagramObject {

    private final String id;
    private final String userName;
    private final String fullName;
    private final String profilePicture;
    private final String bio;
    private final String website;

    public InstagramProfile(String id, String userName, String fullName, String profilePicture,
                            String bio, String website) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.website = website;
    }


    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public String getWebsite() {
        return website;
    }
}
