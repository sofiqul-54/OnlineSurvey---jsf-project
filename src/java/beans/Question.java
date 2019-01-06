package beans;

import dao.TopicDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id, text, opt1, opt2, opt3, topicid, message, answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }
    public SelectItem[] getOptions() {
        return options;
    }

    public void setOptions(SelectItem[] options) {
        this.options = options;
    }
    private SelectItem options[] = new SelectItem[3];

    public Question() {
    }

    public Question(String id, String text, String opt1, String opt2, String opt3, String topicid) {
        this.id = id;
        this.text = text;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.topicid = topicid;
    }

    public Question(String id, String text, String opt1, String opt2, String opt3) {
        this.id = id;
        this.text = text;
        this.options[0] = new SelectItem(1,opt1);
        this.options[1] = new SelectItem(2,opt2);
        this.options[2] = new SelectItem(3,opt3);
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
    }

    public void add(ActionEvent evt) {
        topicid = (String) Request.getSession().getAttribute("topicid");
        System.out.println("Topic ID : " + topicid);
        if (TopicDAO.addQuestion(this)) {
            message = "Added Question Successfully!";
        } else {
            message = "Sorry! Could't Add Question!";
        }
    }
}
