package bg.jug.website.user.service.dto;

import java.util.List;

public class RoleUpdate {

    private String email;

    private List<String> roleUpdates;

    public RoleUpdate() {
    }

    public RoleUpdate(String email, List<String> roleUpdates) {
        this.email = email;
        this.roleUpdates = roleUpdates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoleUpdates() {
        return roleUpdates;
    }

    public void setRoleUpdates(List<String> roleUpdates) {
        this.roleUpdates = roleUpdates;
    }
}
