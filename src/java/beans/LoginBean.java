package beans;
import dao.UserDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String uname,password, message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public LoginBean() {
    }

    public String login() {
        boolean result = UserDAO.login(uname, password);
        if ( result)  {
            Request.getSession().setAttribute("uname",uname);
            return "home";
        }
        else {
            message = "Invalid Login. Please Try Again!";
            return "login";
        }


    }
    
    public String logout() throws IOException {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("uname", "");
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 
        return "index";
    }
}
