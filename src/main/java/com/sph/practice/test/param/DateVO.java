package com.sph.practice.test.param;

import java.time.LocalDate;

/**
 * Created by Shen Peihong on 2020/10/21 19:45
 * Description:
 *
 * @since 1.0.0
 */
public class DateVO {
    private LocalDate date;
    private BankVO bankVO;
    private TeacherVO teacherVO;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }

    public TeacherVO getTeacherVO() {
        return teacherVO;
    }

    public void setTeacherVO(TeacherVO teacherVO) {
        this.teacherVO = teacherVO;
    }
}
