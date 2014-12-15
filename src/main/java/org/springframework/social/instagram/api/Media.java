package org.springframework.social.instagram.api;

import java.util.List;

/**
 *
 * Model class representing a Media object in Instagram (essentially this is a pivot object)
 *
 * @author erusak.
 */
//TODO [erusak] Remove default protected constructor and make fields final
public class Media extends InstagramObject {

    private /*final*/ Type type;

    private /*final*/ List<String> tags;

    private /*final*/ long createdTime;

    private /*final*/ String id;

    private /*final*/ Long likes;

    private /*final*/ String link;

    private /*final*/ InstagramProfile ownerProfile;

    protected Media(){}

    public Media(String id, long createdTime, Type type, List<String> tags, Long likes, String link, InstagramProfile ownerProfile) {
        this.type = type;
        this.tags = tags;
        this.createdTime = createdTime;
        this.id = id;
        this.likes = likes;
        this.link = link;
        this.ownerProfile = ownerProfile;
    }

    public Type getType() {
        return type;
    }

    public List<String> getTags() {
        return tags;
    }

    /**
     * returns UNIX based seconds for the creation time
     * @return UNIX based seconds
     */
    public long getCreatedTime() {
        return createdTime;
    }

    public String getId() {
        return id;
    }

    public static enum Type { IMAGE, VIDEO, UNKNOWN }

    public Long getLikes() {
        return likes;
    }

    public String getLink() {
        return link;
    }

    public InstagramProfile getOwnerProfile() {
        return ownerProfile;
    }
}
