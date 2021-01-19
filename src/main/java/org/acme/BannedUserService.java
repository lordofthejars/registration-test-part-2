package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BannedUserService {
    
    @RestClient
    BannedUserClient bannedUserClient;

    public boolean isBanned(String username) {
        String banned = bannedUserClient.isBanned(username);
        return Boolean.valueOf(banned);
    }

}
