package dbexemple.entity;

public class ImplProj {
    private Long employeeId;
    private Long projectId;

    public ImplProj() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImplProj implProj = (ImplProj) o;

        if (employeeId != null ? !employeeId.equals(implProj.employeeId) : implProj.employeeId != null) return false;
        if (projectId != null ? !projectId.equals(implProj.projectId) : implProj.projectId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImplProj{" +
                "employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
