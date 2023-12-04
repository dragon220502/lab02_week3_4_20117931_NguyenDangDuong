package dangduong.vn.edu.iuh.ongk.fontend.controllers;

import dangduong.vn.edu.iuh.ongk.fontend.model.CustomerModel;
import dangduong.vn.edu.iuh.ongk.fontend.model.EmployeeModel;
import dangduong.vn.edu.iuh.ongk.fontend.model.OrderModel;
import dangduong.vn.edu.iuh.ongk.fontend.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "ControlServlet", value = "/control-servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
public class Controller extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object option = req.getParameter("action");
            if (option!=null){
                if(option.equals("insertEmp")){
                    EmployeeModel abc = new EmployeeModel();
                    abc.insertEmployee(req,resp);
                }
                else if(option.equals("updateEmp")){
                    EmployeeModel abc = new EmployeeModel();
                    abc.updateEmployee(req, resp);
                }else if(option.equals("insertCust")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.addCustomer(req,resp);
                }
                else if(option.equals("updateCust")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.updateCustomer(req,resp);
                }
                else if(option.equals("insertOrder")){
                    OrderModel orderModel = new OrderModel();
                    orderModel.addOrder(req, resp);
                }
                else if(option.equals("updateOrder")){
                    OrderModel orderModel = new OrderModel();
                    orderModel.updateOrder(req, resp);
                }
                else if(option.equals("insertProduct")){
                    ProductModel productModel= new ProductModel();
                    productModel.insertProduct(req,resp);
                }
                else if(option.equals("updateProduct")){
                    long id = Long.parseLong(req.getParameter("id"));
                    ProductModel productModel= new ProductModel();
                    productModel.updateProduct(req,resp);
                }


            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object option = req.getParameter("action");
            if (option!=null){
                if(option.equals("listEmp")){
                    EmployeeModel abc = new EmployeeModel();
                    abc.getEmployeeList(req,resp);
                }
                else if(option.equals("deleteEmp")){
                    EmployeeModel abc = new EmployeeModel();
                    abc.deleteEmployee(req, resp);
                }else if(option.equals("listCust")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.getCustomerList(req,resp);
                }
                else if(option.equals("deleteCust")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.deleteCustomer(req,resp);
                }
                else if(option.equals("listOrder")){
                    OrderModel orderModel = new OrderModel();
                    orderModel.getAllOrder(req, resp);
                }
                else if(option.equals("deleteOrder")){
                    OrderModel orderModel = new OrderModel();
                    orderModel.deleteOrder(req, resp);
                }
                else if(option.equals("listProduct")){
                    ProductModel productModel= new ProductModel();
                    productModel.getAll(req,resp);
                }else if(option.equals("deleteProduct")){
                    ProductModel productModel= new ProductModel();
                    productModel.deleteProduct(req,resp);
                }


            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
