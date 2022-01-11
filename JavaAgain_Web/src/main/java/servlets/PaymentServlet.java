package servlets;

import beans.PaymentBean;
import constants.Constants;
import entity.Payment;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="PaymentServlet", value = "/")
public class PaymentServlet extends HttpServlet {
    // NOTE: Uncomment if server is TomEE
    // @EJB
    PaymentBean paymentBean = new PaymentBean();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Payment> payments = paymentBean.getAllPayments();
        request.setAttribute("payments", payments);
        request.getRequestDispatcher(Constants.IndexPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        System.out.print("1");

        if (!validateRequest(request)) {
            System.out.print("2");
            doGet(request, response);
        }


        final String code = request.getParameter("code");
        final String value = request.getParameter("value");

        final Payment payment = new Payment(Integer.valueOf(value), code);
        System.out.print("333");
        paymentBean.addPayment(payment);
        System.out.print("444");

        doGet(request, response);
    }

    private boolean validateRequest(final HttpServletRequest req) {

        final String code = req.getParameter("code");
        final String value = req.getParameter("value");

        return code != null && code.length() > 0 &&
                value != null && value.length() > 0 &&
                value.matches("[+]?\\d+");
    }
}
