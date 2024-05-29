package controller;

import model.Book;
import service.BookService;
import service.iService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/books")
public class BookController extends HttpServlet {
    private iService<Book> bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "home":
                showHome(req, resp);
                break;
            case "create":
                showFromCreate(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "edit":
                showFromEdit(req, resp);
                break;
            default:
                showError(req, resp);
                break;
        }
    }

    public void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.findAll();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/home.jsp");
        req.setAttribute("bookList", bookList);
        requestDispatcher.forward(req, resp);
    }

    public void showFromCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.delete(id);
        resp.sendRedirect("/books?action=home");
    }

    public void showFromEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int index = bookService.findById(id);
        Book book = bookService.findAll().get(index);
        req.setAttribute("book", book);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void showError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/error.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                addBook(req, resp);
                break;
            case "edit":
                editBook(req, resp);
                break;
            default:
                showError(req, resp);
                break;
        }
    }

    public void editBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        String image = req.getParameter("image");
        Book book = new Book(id, name, price, description, author, image);
        bookService.edit(book, id);
        resp.sendRedirect("/books?action=home");
    }

    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        String image = req.getParameter("image");
        Book book = new Book(id, name, price, description, author, image);
        bookService.add(book);
        resp.sendRedirect("/books?action=home");
    }
}
