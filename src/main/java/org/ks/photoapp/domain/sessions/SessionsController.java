package org.ks.photoapp.domain.sessions;

import org.kamilastd.photoSession.dto.PhotoSessionDto;
import org.kamilastd.photoSession.PhotoSessionService;

import java.sql.SQLException;

public class SessionsController {

    PhotoSessionService photoSessionService;
//    public List<PhotoSessionDTS> displayAllSessions(){
//        List<PhotoSessionEntity> list = photoSessionService.getAllPhotoSessionFromDatabase();
//        return photoSessionService.prepareListOfSessionsDTS(list);
//    }

    public void createNewSession(PhotoSessionDto session) throws SQLException {
        photoSessionService.createNewSession(session);
    }

  //  public PhotoSessionDTS updateSession(PhotoSessionDTS session){

  //  }


}
