package org.springframework.social.instagram.connect;

import org.springframework.social.ApiException;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

/**
 *
 * Instagram ApiAdapter implementation
 *
 * @author erusak.
 */
public class InstagramAdapter implements ApiAdapter<Instagram> {

    @Override
    public boolean test(Instagram instagram) {
        try {
            instagram.userOperations().getUserProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Instagram instagram, ConnectionValues values) {
        InstagramProfile profile = instagram.userOperations().getUserProfile();
        values.setProviderUserId(profile.getId());
        values.setDisplayName(profile.getFullName());
        values.setImageUrl(profile.getProfilePicture());
    }

    @Override
    public UserProfile fetchUserProfile(Instagram instagram) {
        InstagramProfile profile = instagram.userOperations().getUserProfile();
        return new UserProfileBuilder().setName(profile.getFullName()).setUsername(profile.getUserName()).build();
    }

    @Override
    public void updateStatus(Instagram instagram, String message) {
        // TODO implemented
        throw new UnsupportedOperationException("[instagram][updateStatus is not supported yet]");
    }
}
