package sg.edu.ntu.tera.v2.app.web.action;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import sg.edu.ntu.tera.v2.app.facade.DepartmentFacade;
import sg.edu.ntu.tera.v2.app.model.Department;
import sg.edu.ntu.tera.v2.app.model.OperationArea;
import sg.edu.ntu.tera.v2.app.model.Region;
import sg.edu.ntu.tera.v2.app.model.User;
import sg.edu.ntu.tera.v2.infr.facade.FacadeServiceLocator;

public class DepartmentAction extends DepartmentRoot {

  private static final long serialVersionUID = -492972374826305025L;

  @Override
  public String doGetCreate() {
    HttpServletRequest request = ServletActionContext.getRequest();

    setRegions(request);
    setOperationAreas(request);
    return ACTION_CREATE;
  }

  @Override
  public String doGetDelete() {

    String id = getInputDepartmentId();
    getFacade().deleteDepartmentWithUsers(new Long(id));
    return doGetList();
  }

  /**
   * Do get delete users.
   *
   * @return the string
   */
  public String doGetDeleteUsers() {
    HttpServletRequest request = ServletActionContext.getRequest();

    String departmentId = getInputDepartmentId();
    String userId = getInputUserId();
    User user = FacadeServiceLocator.getInstance().getUserFacade().selectById(new Long(userId));
    if (user != null && user.getDepartment() != null && departmentId
        .equalsIgnoreCase(String.valueOf(user.getDepartment().getId()))) {
      user.setDepartment(null);
      user.setUpdateBy(getSessionUser(request).getUserName());
      user.setUpdateTime(new Date());
      FacadeServiceLocator.getInstance().getUserFacade().update(user);
    }
    return doGetEdit();
  }

  @Override
  public String doGetEdit() {
    HttpServletRequest request = ServletActionContext.getRequest();

    String departmentId = getInputDepartmentId();
    Department department = getFacade().selectById(new Long(departmentId));
    setRegions(request);
    setOperationAreas(request);
    List<User> users = FacadeServiceLocator.getInstance().getUserFacade().getUnAssignUsers();
    request.setAttribute("users", users);
    List<User> userList = FacadeServiceLocator.getInstance().getUserFacade()
        .getUsersByDepartment(new Long(departmentId));
    request.setAttribute("userList", userList);
    request.setAttribute("department", department);
    return ACTION_EDIT;
  }

  @Override
  public String doGetList() {
    HttpServletRequest request = ServletActionContext.getRequest();

    List<Department> departmentList = getFacade().selectAll();
    request.setAttribute("departmentList", departmentList);
    return ACTION_LIST;
  }

  @Override
  public String doGetView() {
    HttpServletRequest request = ServletActionContext.getRequest();

    String departmentId = getInputDepartmentId();
    Department department = getFacade().selectById(new Long(departmentId));
    List<User> userList = FacadeServiceLocator.getInstance().getUserFacade()
        .getUsersByDepartment(new Long(departmentId));
    request.setAttribute("userList", userList);
    request.setAttribute("department", department);
    return ACTION_VIEW;
  }

  @Override
  public String doPostCreate() {
    HttpServletRequest request = ServletActionContext.getRequest();

    String departmentName = getInputDepartmentName();
    String operationAreaId = getSelectOperationArea();
    String regionId = getSelectRegion();
    String telephoneNumber = getInputTelephoneNumber();
    String officeAddress = getInputOfficeAddress();
    OperationArea operationArea = null;
    if (!StringUtils.isEmpty(operationAreaId)) {
      operationArea = FacadeServiceLocator.getInstance().getOperationAreaFacade()
          .selectById(new Long(operationAreaId));
    }
    Region region = null;
    if (!StringUtils.isEmpty(regionId)) {
      region = FacadeServiceLocator.getInstance().getRegionFacade().selectById(new Long(regionId));
    }
    Department department = getNewEntity();
    department.setDepartmentName(departmentName);
    department.setTelephoneNumber(telephoneNumber);
    department.setOfficeAddress(officeAddress);
    department.setOperationArea(operationArea);
    department.setRegion(region);
    department.setCreateBy(getSessionUser(request).getUserName());
    department.setCreateTime(new Date());
    getFacade().insert(department);
    return doGetList();
  }

  /**
   * Do post create users.
   *
   * @return the string
   */
  public String doPostCreateUsers() {

    String departmentId = getInputDepartmentId();
    String userId = getSelectUser();
    if (!StringUtils.isEmpty(userId)) {
      User user = FacadeServiceLocator.getInstance().getUserFacade().selectById(new Long(userId));
      Department department = getFacade().selectById(new Long(departmentId));
      if (user != null) {
        user.setDepartment(department);
      }
      FacadeServiceLocator.getInstance().getUserFacade().update(user);
    }
    return doGetEdit();
  }

  @Override
  public String doPostEdit() {
    HttpServletRequest request = ServletActionContext.getRequest();

    // get value from input
    String departmentId = getInputDepartmentId();
    String departmentName = getInputDepartmentName();
    String operationAreaId = getSelectOperationArea();
    String regionId = getSelectRegion();
    String telephoneNumber = getInputTelephoneNumber();
    String officeAddress = getInputOfficeAddress();
    String managerId = getSelectManager();
    OperationArea operationArea = null;
    if (!StringUtils.isEmpty(operationAreaId)) {
      operationArea = FacadeServiceLocator.getInstance().getOperationAreaFacade()
          .selectById(new Long(operationAreaId));
    }
    Region region = null;
    if (!StringUtils.isEmpty(regionId)) {
      region = FacadeServiceLocator.getInstance().getRegionFacade().selectById(new Long(regionId));
    }
    User manager = null;
    if (!StringUtils.isEmpty(managerId)) {
      manager = FacadeServiceLocator.getInstance().getUserFacade().selectById(new Long(managerId));
    }
    Department department = getFacade().selectById(new Long(departmentId));
    if (department != null) {
      department.setDepartmentName(departmentName);
      department.setTelephoneNumber(telephoneNumber);
      department.setOfficeAddress(officeAddress);
      department.setOperationArea(operationArea);
      department.setRegion(region);
      department.setManager(manager);
      department.setUpdateBy(getSessionUser(request).getUserName());
      department.setUpdateTime(new Date());
      getFacade().update(department);
    }
    return doGetList();
  }

  @Override
  public DepartmentFacade getFacade() {
    return FacadeServiceLocator.getInstance().getDepartmentFacade();
  }

  @Override
  public Department getNewEntity() {
    return new Department();
  }

  /**
   * Do post check name.
   *
   * @return the string
   */
  public String doPostCheckName() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();

    String departmentName = getInputDepartmentName();
    Department department = getFacade().getDepartmentByName(departmentName);
    boolean result = (department == null);
    response.setContentType("application/json");
    try {
      request.setAttribute("result", result);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ACTION_AJAX;
  }
}
