package com.monk.exam.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monk.exam.common.Result;
import com.monk.exam.dto.StudentDTO;
import com.monk.exam.entity.Student;
import com.monk.exam.service.StudentService;
import com.monk.exam.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * student 表控制层
 * 学生表
 *
 * @author monk
 * @since 2022-04-25 16:28:34
 */
@Api(tags = "学生表")
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * @description 分页查询所有数据
     * @param paramDto DTO 查询实体
     * @return 所有数据
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按字段条件分页查询学生表")
    public Result<?> selectStudentByCondition(@RequestBody StudentDTO paramDto) {
        //设置分页
        Page<Student> studentPage = new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize());
        //查询条件复制
        Student student = new Student();
        BeanUtils.copyProperties(paramDto, student);
        //查询结果,排除password字段
        studentPage = studentService.page(studentPage, new QueryWrapper<>(student)
                .select(Student.class,i -> !i.getColumn().equals("password")));
        //类型转换
        IPage<StudentVO> studentVoPage = Convert.convert(new TypeReference<IPage<StudentVO>>(){}, studentPage);
        return Result.success(studentVoPage);
    }

    /**
     * @description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询学生表")
    public Result<?> selectById(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        //查询结果类型转换
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        return Result.success(studentVO);
    }

    /**
     * @description 新增数据
     * @param paramDto DTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增学生表数据")
    public Result<?> addStudent(@RequestBody StudentDTO paramDto) {
        //数据校验
        
        //类型转换
        Student student = new Student();
        BeanUtils.copyProperties(paramDto,student);
        return Result.flag(studentService.save(student));
    }
    
    
    /**
     * @description 修改数据
     * @param paramDto DTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("根据Id更新学生表")
    public Result<?> updateById(@RequestBody StudentDTO paramDto) {
        //数据校验
        
        //类型转换
        Student student = new Student();
        BeanUtils.copyProperties(paramDto,student);
        return Result.flag(studentService.updateById(student));
    }
    
    /**
     * @description 批量修改数据
     * @param paramDtoList DTO 实体对象
     * @return 修改结果
     */
    @PutMapping("updateList")
    @ApiOperation("根据idList批量更新学生表")
    public Result<?> updateStudentList(@RequestBody List<StudentDTO> paramDtoList) {
        //数据校验
        
        //类型转换
        List<Student> studentList = Convert.convert(new TypeReference<List<Student>>(){}, paramDtoList);
        return Result.flag(studentService.updateBatchById(studentList));
    }
    
    /**
     * @description 删除单条数据
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @ApiOperation("根据id删除学生表数据")
    public Result<?> deleteById(@PathVariable("id") Long id) {
        Student student = new Student();
        student.setId(id);
        return Result.flag(studentService.removeById(student));
    }
    
    /**
     * @description 批量删除数据
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除学生表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        List<Student> studentList = studentService.listByIds(idList);
        return Result.flag(studentService.removeBatchByIds(studentList));
    }

    /**
     * @description 根据用户名和密码查询单条数据,完成登录验证
     * @param paramDto DTO 实体对象
     * @return StudentVO 学生VO对象
     */
    @PostMapping("login")
    @ApiOperation("根据用户名密码查询后台用户表,完成登录")
    public Result<?> login(@RequestBody StudentDTO paramDto){
        //查询条件复制
        Student student = new Student();
        BeanUtils.copyProperties(paramDto, student);
        // 验证用户信息
        student = studentService.getOne(new QueryWrapper<>(student));
        // 验证查询结果
        if (student == null) {
            return Result.error("用户名或密码错误");
        }
        if (student.getLocked() == 1) {
            return Result.error("账户被锁定，请联系管理员");
        }
        // 记录登录时间
        studentService.login(student.getId());
        //查询结果类型转换
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        return Result.success(studentVO);
    }
}