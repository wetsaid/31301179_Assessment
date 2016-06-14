<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h2 class="modal-title">教师信息</h2>
            </div>
            <form action="teacher!updateInformation.action" method="post" class="form-horizontal">
                <div class="modal-body">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-8">
                            <input name="teacher.teacherName" value="${teacher.teacherName}" type="text"
                                   class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-8">
                            <div class="radio-inline"><label>
                                <input type="radio" name="teacher.teacherSex" value="男"
                                       <c:if test="${teacher.teacherSex=='男'}">checked</c:if>/> 男
                            </label></div>
                            <div class="radio-inline"><label>
                                <input type="radio" name="teacher.teacherSex" value="女"
                                       <c:if test="${teacher.teacherSex=='女'}">checked</c:if>/> 女
                            </label></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学位</label>
                        <div class="col-sm-8">
                            <input name="teacher.teacherDegree" value="${teacher.teacherDegree}" type="text"
                                   class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-8">
                            <input name="teacher.teacherPosition" value="${teacher.teacherPosition}" type="text"
                                   class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职称</label>
                        <div class="col-sm-8">
                            <input name="teacher.professionalTitle" value="${teacher.professionalTitle}"
                                   type="text" class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">手机号</label>
                        <div class="col-sm-8">
                            <input name="teacher.teacherPhoneNumber" value="${teacher.teacherPhoneNumber}"
                                   type="text" class="form-control1">
                        </div>
                    </div>

                    <input type="hidden" name="teacher.teacherId" value="${teacher.teacherId}"/>
                    <input type="hidden" name="teacher.teacherAccount" value="${teacher.teacherAccount}"/>
                    <input type="hidden" name="teacher.teacherPassword" value="${teacher.teacherPassword}"/>
                    <input type="hidden" name="teacher.teacherStatus" value="${teacher.teacherStatus}"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <input type="submit" class="btn btn-primary" value="修改"></input>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
