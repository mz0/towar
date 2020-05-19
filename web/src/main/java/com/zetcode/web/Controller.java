package com.zetcode.web;

import com.zetcode.bean.Car;
import com.zetcode.service.CarsService;
import com.zetcode.service.ICarsService;
import com.zetcode.util.ValidateParameter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    private static final String ACTION_KEY = "action";
    private static final String READ_CAR_BY_ID_VIEW = "readCarId.jsp";
    private static final String SHOW_CAR_VIEW = "showCar.jsp";
    private static final String READ_CAR_VIEW = "readCar.jsp";
    private static final String CAR_SAVED_VIEW = "carSaved.jsp";
    private static final String ALL_CARS_VIEW = "allCars.jsp";
    private static final String UNKNOWN_VIEW = "unknown.jsp";
    private static final String WRONG_PARAMS_VIEW = "wrongParams.jsp";
    private static final String LIST_CARS_ACTION = "listcars";
    private static final String READ_CAR_BY_ID_ACTION = "readbyid";
    private static final String READ_CAR_ACTION = "readcar";
    private static final String VIEW_CAR_ACTION = "viewcar";
    private static final String SAVE_CAR_ACTION = "savecar";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String actionName = request.getParameter(ACTION_KEY);
        String page = UNKNOWN_VIEW;

        if (LIST_CARS_ACTION.equals(actionName)) {
            ICarsService service = new CarsService();
            request.setAttribute("carList", service.findAllCars());
            page = ALL_CARS_VIEW;
        }

        if (READ_CAR_BY_ID_ACTION.equals(actionName)) {
            page = READ_CAR_BY_ID_VIEW;
        }     

        if (READ_CAR_ACTION.equals(actionName)) {
            page = READ_CAR_VIEW;
        }             

        if (VIEW_CAR_ACTION.equals(actionName)) {
            String sid = request.getParameter("carId");
            if (ValidateParameter.validateId(sid)) {
                ICarsService service = new CarsService();
                Long carId = Long.valueOf(sid);
                request.setAttribute("returnedCar", service.findCar(carId));

                page = SHOW_CAR_VIEW;
            } else {
                page = WRONG_PARAMS_VIEW;
            }
        }
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + page);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        String actionName = request.getParameter(ACTION_KEY);
        String page = UNKNOWN_VIEW;        

        if (SAVE_CAR_ACTION.equals(actionName)) {
            String sname = request.getParameter("carName");
            String sprice = request.getParameter("carPrice");

            if (ValidateParameter.validateName(sname)
                    && ValidateParameter.validatePrice(sprice)) {
                Car car = new Car();
                car.setName(sname);
                car.setPrice(Integer.valueOf(sprice));

                ICarsService service = new CarsService();
                service.saveCar(car);

                request.getSession().setAttribute("carName", sname);
                request.getSession().setAttribute("carPrice", sprice);
                page = CAR_SAVED_VIEW;
            } else {
                page = WRONG_PARAMS_VIEW;
            }
        }    
        response.sendRedirect(page);
    }
}
