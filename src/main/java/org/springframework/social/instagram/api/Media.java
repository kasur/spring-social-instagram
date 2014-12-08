package org.springframework.social.instagram.api;

import java.util.List;

/**
 *
 * Model class representing a Media object in Instagram (essentially this is a pivot object)
 *
 * @author erusak.
 */
public class Media extends InstagramObject {

    private final Type type;

    private final List<String> tags;

    private final long createdTime;

    private final String id;

    private final Long likes;

    public Media(String id, long createdTime, Type type, List<String> tags, Long likes) {
        this.type = type;
        this.tags = tags;
        this.createdTime = createdTime;
        this.id = id;
        this.likes = likes;
    }

    public Type getType() {
        return type;
    }

    public List<String> getTags() {
        return tags;
    }

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
}
