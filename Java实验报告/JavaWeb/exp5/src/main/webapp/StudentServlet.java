package cn.edu.qust.exp5.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import cn.edu.qust.exp5.entity.Student;
import cn.edu.qust.exp5.service.*;
import cn.edu.qust.exp5.service.StudentService;

@WebServlet(name = "studentServlet", value = "/studentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                delete(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "insert":
                insert(request, response);
                break;
            case "findBySno":
                findBySno(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");

        StudentService service = new StudentService();
        boolean flag = service.delete(sno);

        if (flag) {
            request.setAttribute("msg", "ɾ���ɹ���");
        } else {
            request.setAttribute("msg", "ɾ��ʧ�ܣ�");
        }

        request.getRequestDispatcher("/studentServlet?action=findAll").forward(request, response);
    }

//    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // ֱ��ת���� add.jsp ҳ�棬���û���д��Ϣ
//        request.getRequestDispatcher("/studentInsert.jsp").forward(request, response);
//    }

//    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sno = request.getParameter("sno");
//        String sname = request.getParameter("sname");
//        String ageStr = request.getParameter("age");
//
//        // ��������ֶ��Ƿ�Ϊ��
//        if (sno == null || sname == null || ageStr == null || sno.isEmpty() || sname.isEmpty() || ageStr.isEmpty()) {
//            request.setAttribute("msg", "�����ֶζ��Ǳ���ģ�");
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//            return; // ֱ�ӷ���
//        }
//
//        int age;
//        try {
//            age = Integer.parseInt(ageStr);
//        } catch (NumberFormatException e) {
//            request.setAttribute("msg", "���������һ����Ч�����֣�");
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//            return; // ֱ�ӷ���
//        }
//
//        // ����ѧ������
//        Student stu = new Student();
//        stu.setSno(sno);
//        stu.setSname(sname);
//        stu.setAge(age);
//
//        // ���÷����
//        StudentService service = new StudentService();
//        boolean flag = service.insert(stu);
//
//        // ���ؽ��
//        if (flag) {
//            request.setAttribute("msg", "��ӳɹ���");
//        } else {
//            request.setAttribute("msg", "���ʧ�ܣ�");
//        }
//
//        request.getRequestDispatcher("/studentServlet?action=findAll").forward(request, response);
//    }


//    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sno = request.getParameter("sno");
//        String sname = request.getParameter("sname");
//        String ageStr = request.getParameter("age"); // �����ȡ�����ַ���
//
//        // ��������ֶ��Ƿ�Ϊ��
//        if (sno == null || sname == null || ageStr == null || sno.isEmpty() || sname.isEmpty() || ageStr.isEmpty()) {
//            request.setAttribute("msg", "�����ֶζ��Ǳ���ģ�");
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//            return; // ֱ�ӷ���
//        }
//
//        int age;
//        try {
//            age = Integer.parseInt(ageStr); // ����ת������
//        } catch (NumberFormatException e) {
//            request.setAttribute("msg", "���������һ����Ч�����֣�");
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//            return; // ֱ�ӷ���
//        }
//
//        // ����ѧ��������������
//        Student stu = new Student();
//        stu.setSno(sno);
//        stu.setSname(sname);
//        stu.setAge(age);
//
//        // ���÷����
//        StudentService service = new StudentService();
//        boolean flag = service.update(stu);
//
//        // ���ؽ��
//        if (flag) {
//            request.setAttribute("msg", "�޸ĳɹ���");
//        } else {
//            request.setAttribute("msg", "�޸�ʧ�ܣ�");
//        }
//
//        request.getRequestDispatcher("/studentServlet?action=findAll").forward(request, response);
//    }



    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("age"));

        Student stu = new Student();
        stu.setSno(sno);
        stu.setSname(sname);
        stu.setAge(age);

        StudentService service = new StudentService();
        boolean flag = service.update(stu);

        if (flag) {
            request.setAttribute("msg", "�޸ĳɹ���");
        } else {
            request.setAttribute("msg", "�޸�ʧ�ܣ�");
        }

        request.getRequestDispatcher("/studentServlet?action=findAll").forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("age"));

        Student stu = new Student();
        stu.setSno(sno);
        stu.setSname(sname);
        stu.setAge(age);

        StudentService service = new StudentService();
        boolean flag = service.insert(stu);

        if (flag) {
            request.setAttribute("msg", "��ӳɹ���");
        } else {
            request.setAttribute("msg", "���ʧ�ܣ�");
        }

        request.getRequestDispatcher("/studentServlet?action=findAll").forward(request, response);
    }

    private void findBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");

        StudentService service = new StudentService();
        Student student = service.findBySno(sno);

        request.setAttribute("student", student);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService service = new StudentService();
        List<Student> students = service.findAll();

        request.setAttribute("students", students);
        request.getRequestDispatcher("/disp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
