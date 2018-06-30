package dbexemple.entity;

public class ImplProj {
    private Long employeeID;
    private Long projectID;

    public ImplProj() {
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImplProj implProj = (ImplProj) o;

        if (employeeID != null ? !employeeID.equals(implProj.employeeID) : implProj.employeeID != null) return false;
        if (projectID != null ? !projectID.equals(implProj.projectID) : implProj.projectID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeID != null ? employeeID.hashCode() : 0;
        result = 31 * result + (projectID != null ? projectID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImplProj{" +
                "employeeID=" + employeeID +
                ", projectID=" + projectID +
                '}';
    }
}
