<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h2 class="modal-title">学生信息</h2>
            </div>
            <form action="student!updateInformation.action" method="post" class="form-horizontal">
                <div class="modal-body">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-8">
                            <input name="student.studentName" value="${student.studentName}" type="text"
                                   class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-8">
                            <div class="radio-inline"><label>
                                <input type="radio" name="student.studentSex" value="男"
                                       <c:if test="${student.studentSex=='男'}">checked</c:if>/> 男
                            </label></div>
                            <div class="radio-inline"><label>
                                <input type="radio" name="student.studentSex" value="女"
                                       <c:if test="${student.studentSex=='女'}">checked</c:if>/> 女
                            </label></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">入学日期</label>
                        <div class="col-sm-8">
                            <input name="student.admissionDate" value="${student.admissionDate}" type="text"
                                   class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">行政班</label>
                        <div class="col-sm-8">
                            <input name="student.administrativeClass" value="${student.administrativeClass}"
                                   type="text" class="form-control1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">行政班</label>
                        <div class="col-sm-8">
                            <input name="student.studentPhoneNumber" value="${student.studentPhoneNumber}"
                                   type="text" class="form-control1">
                        </div>
                    </div>

                    <input type="hidden" name="student.studentId" value="${student.studentId}"/>
                    <input type="hidden" name="student.studentAccount" value="${student.studentAccount}"/>
                    <input type="hidden" name="student.studentPassword" value="${student.studentPassword}"/>
                    <input type="hidden" name="student.studentStatus" value="${student.studentStatus}"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <input type="submit" class="btn btn-primary" value="修改"></input>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
