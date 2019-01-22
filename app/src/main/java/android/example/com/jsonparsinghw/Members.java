package android.example.com.jsonparsinghw;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private StringBuilder membersString = new StringBuilder();
    private List<String> membersList = new ArrayList<>();

    public Members(List<String> membersList) {
        this.membersList = membersList;
    }

    public Members () {}

    public String getMembers(JSONArray members) {
        for (int i = 0; i < membersList.size(); i++) {
            membersString.append(i);
            membersString.append("\n");
        }
        return membersString.toString();
    }

    public void setMembers(List<String> members) {
        this.membersList = membersList;
    }
}
