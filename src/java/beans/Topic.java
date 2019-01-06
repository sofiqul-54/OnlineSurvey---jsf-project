package beans;

import dao.TopicDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title, id, addedon, uname, message;
    private ArrayList<Question> questions = null;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public Topic() {
    }

    public Topic(String id, String title, String addedon, String uname) {
        this.title = title;
        this.id = id;
        this.addedon = addedon;
        this.uname = uname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddedon() {
        return addedon;
    }

    public void setAddedon(String addedon) {
        this.addedon = addedon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void add(ActionEvent evt) {
        boolean done = TopicDAO.add(Request.getSession().getAttribute("uname").toString(), title);
        if (done) {
            message = "Topic has been added!";
        } else {
            message = "Sorry! Topic was not added!";
        }
    }

    public void delete(String id) {
        boolean done = TopicDAO.delete(id);
        if (done) {
            message = "Topic has been deleted!";
        } else {
            message = "Sorry! Topic was not deleted!";
        }
    }
    public String deleteQuestion(String id) {
        boolean done = TopicDAO.deleteQuestion(id);
        if (done) {
            message = "Question has been deleted!";
        } else {
            message = "Sorry! Question was not deleted!";
        }
        return "topicquestions?topicid="+id;
    }

    public List<Topic> getTopics() {
        return TopicDAO.getTopics();
    }
    public ArrayList<SelectItem> getTopicsName() {
        ArrayList<Topic>  lst = TopicDAO.getTopics();
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();

        for ( Topic t : lst)
            items.add( new SelectItem( t.getId(), t.getTitle()));

        return items;
    }

    public List<Question> getQuestions() {
        // get id from querystring
        return TopicDAO.getQuestions(Request.getRequest().getParameter("topicid"));
    }

    public List<SurveyResult> getSurveyResults() {
        // get id from querystring
        return TopicDAO.getSurveyResults(Request.getRequest().getParameter("topicid"));
    }
    
    public String process() {
         // get questions for the selected topic
         position = 0;
         questions  = TopicDAO.getQuestions(id);
         return "survey";
    }
    
    public Question getQuestion() {
        return  questions.get(position);
    }

    public int getQuestionCount() {
        return questions.size();
    }

    public void next(ActionEvent evt) {
          position ++;
    }

    public void previous(ActionEvent evt) {
          position --;
    }

    public String cancel() {
          return "index";
    }
   
    public String finish() {
        // process the results
        boolean done = TopicDAO.storeSurveyResults(id, questions);
        if ( done )
            return "finish";
        else
            return "error";
    }
}
