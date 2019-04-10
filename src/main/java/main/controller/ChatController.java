package main.controller;


import io.swagger.annotations.*;
import main.model.po.Chat;
import main.model.po.User;
import main.model.vo.ChatVo;
import main.service.ChatService;
import main.util.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/chat")
@Api(tags = "聊天相关", description = "/chat")
public class ChatController extends ExceptionController{

    @Autowired
    private ChatService chatService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation("/新增一条聊天记录 需要登录，发送者为当前用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "toid", required = true, value = "发送的人的id"),
            @ApiImplicitParam(name = "msg", required = true, value = "发送的信息")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "其他为失败")
    })
    @PostMapping("/send")
    public CommonReturnType addMsg(@RequestParam("toid") Long toid
                        , @RequestParam("msg") String msg)
    {
        //根据token从redis获取用户
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        Chat c = new Chat();
        //其他参数按照数据库默认设置
        c.setToid(toid);
        c.setFromid(u.getId());
        c.setMsg(msg);
        chatService.addOne(c);
        //对应用户是否有新消息设置为true
        redisTemplate.opsForValue().set(toid, "true");
        return CommonReturnType.ok();
    }

    @GetMapping("/new")
    @ApiOperation("/查询是否有新的消息")
    @ApiResponses({
            @ApiResponse(code = 440, message = "无"),
            @ApiResponse(code = 200, message = "有")
    })
    public CommonReturnType haveNew()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        Object o = redisTemplate.opsForValue().get(u.getId());
        if(o == null)
            return CommonReturnType.errorWithCode(440, "无");
        else
        {
            return CommonReturnType.ok();
        }
    }

    @ApiOperation("发送此请求后,查询是否有新消息会返回false")
    @DeleteMapping("/new")
    public CommonReturnType deleteNew()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        Object o = redisTemplate.opsForValue().get(u.getId());
        if(o != null)
        {
            redisTemplate.delete(u.getId());
        }
        return CommonReturnType.ok();

    }

    @GetMapping("/all")
    @ApiOperation("查询当前用户的所有聊天记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "200成功,,其他的都是失败" +
                    "返回信息是个map（会转成json）, key为和你有过聊天记录的人，" +
                    "value是个数组，为你和他的所有聊天记录，按时间排好序" +
                    "from:谁发的" +
                    "to：发给谁" +
                    "msg  消息" +
                    "sendTime 发送时间 ")

    })
    public CommonReturnType getALl()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        Object o = redisTemplate.opsForValue().get(u.getId());
        if(o != null)
            redisTemplate.delete(u.getId());
        Map<String, List<ChatVo>> myAll = chatService.getMyAll(u.getId());
        return CommonReturnType.ok(myAll);
    }

}
