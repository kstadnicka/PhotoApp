package org.ks.photoapp.domain.sessions;

import org.kamilastd.photoSession.PhotoSession;

import java.util.List;

public class SessionDao {

    public Long updateSessionWhereId(PhotoSession photoSession){
        return photoSession.getId();
    }



    public Long findSessionWithHighestId() {
        //Looking database
        return 5L;
    }

    public List<PhotoSession> getAllSessionFromDatabase() {

        return null;
    }

    // public void saveNewSession(PhotoSessionEntity photoSessionEntity) {
   //     String query = ""
   // }
}
