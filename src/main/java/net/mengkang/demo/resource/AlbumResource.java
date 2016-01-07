package net.mengkang.demo.resource;

import net.mengkang.demo.bo.AlbumInfo;
import net.mengkang.nettyrest.ApiProtocol;
import net.mengkang.demo.service.AlbumService;
import net.mengkang.nettyrest.vo.Info;
import net.mengkang.nettyrest.vo.Result;
import net.mengkang.nettyrest.BaseResource;

public class AlbumResource extends BaseResource {

    public AlbumResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Object get() {

        int uid, aid;

        Object uidCheck = parameterIntCheck(apiProtocol, "uid");
        if (uidCheck instanceof Result) {
            return uidCheck;
        } else {
            uid = (int) uidCheck;
        }

        Object aidCheck = parameterIntCheck(apiProtocol,"aid");
        if (aidCheck instanceof Result){
            return aidCheck;
        }else {
            aid = (int) aidCheck;
        }

        AlbumService albumService = new AlbumService(apiProtocol);

        return new Result<Info>(new AlbumInfo(albumService.get(aid,uid)));
    }
}