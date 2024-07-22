package hello.servlert.web.frontcontroller.v5;

import hello.servlert.web.frontcontroller.ModelView;
import hello.servlert.web.frontcontroller.MyView;
import hello.servlert.web.frontcontroller.v3.ControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberFromControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlert.web.frontcontroller.v4.ControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberFromControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlert.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.servlert.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFromControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFromControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //핸들러 매핑 젇보 반환 1
        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //핸들러를 처리할 수 있는 핸들러 어댑터 조회 2
        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(request, response, handler);

        String viewName = mv.getViewName();// 논리 이름 new-form
        MyView view = viewResover(viewName);

        view.render(mv.getModel(),request,response);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }

        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다." + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyView viewResover(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
