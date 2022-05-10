package com.monk.exam.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.monk.exam.entity.StudentPaperAnswer;
import com.monk.exam.service.StudentPaperAnswerService;
import com.monk.exam.dto.StudentPaperAnswerDTO;
import com.monk.exam.vo.StudentPaperAnswerVO;
import com.monk.exam.common.Result;
import javax.annotation.Resource;
import java.util.List;

/**
 * student_paper_answer 表控制层
 * 学生试卷答案表
 *
 * @author monk
 * @since 2022-05-04 14:12:43
 */
@Api(tags = "学生试卷答案表")
@RestController
@RequestMapping("studentPaperAnswer")
public class StudentPaperAnswerController {
    /**
     * 服务对象
     */
    @Resource
    private StudentPaperAnswerService studentPaperAnswerService;

    /**
     * @description 分页查询所有数据
     * @param paramDto DTO 查询实体
     * @return 所有数据
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按字段条件分页查询学生试卷答案表")
    public Result<?> selectStudentPaperAnswerByCondition(@RequestBody StudentPaperAnswerDTO paramDto) {
        //设置分页
        Page<StudentPaperAnswer> studentPaperAnswerPage = new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize());
        //查询条件复制
        StudentPaperAnswer studentPaperAnswer = new StudentPaperAnswer();
        BeanUtils.copyProperties(paramDto, studentPaperAnswer);
        //查询结果类型转换
        studentPaperAnswerPage = studentPaperAnswerService.page(studentPaperAnswerPage, new QueryWrapper<>(studentPaperAnswer));
        IPage<StudentPaperAnswerVO> studentPaperAnswerVoPage = Convert.convert(new TypeReference<IPage<StudentPaperAnswerVO>>(){}, studentPaperAnswerPage);
        return Result.success(studentPaperAnswerVoPage);
    }

    /**
     * @description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询学生试卷答案表")
    public Result<?> selectById(@PathVariable("id") Long id) {
        StudentPaperAnswer studentPaperAnswer = studentPaperAnswerService.getById(id);
        //查询结果类型转换
        StudentPaperAnswerVO studentPaperAnswerVO = new StudentPaperAnswerVO();
        BeanUtils.copyProperties(studentPaperAnswer,studentPaperAnswerVO);
        return Result.success(studentPaperAnswerVO);
    }

    /**
     * @description 通过学生ID和试卷查询多条数据
     * @param studentId 学生ID
     * @param paperId 试卷ID
     * @return 单条数据
     */
    @GetMapping("{studentId}/{paperId}")
    @ApiOperation("根据id查询学生试卷答案表")
    public Result<?> selectList(@PathVariable("studentId") String studentId,@PathVariable("paperId") String paperId) {
        List<StudentPaperAnswer> studentPaperAnswers = studentPaperAnswerService.list(new LambdaQueryWrapper<StudentPaperAnswer>()
                .eq(StudentPaperAnswer::getStudentId, studentId)
                .eq(StudentPaperAnswer::getPaperId, paperId));
        return Result.success(studentPaperAnswers);
    }

    /**
     * @description 新增/修改数据
     * @param paramDto DTO 实体对象
     * @return 新增/修改结果
     */
    @PostMapping
    @ApiOperation("新增/更新学生试卷答案表数据")
    public Result<?> addStudentPaperAnswer(@RequestBody StudentPaperAnswerDTO paramDto) {
        //数据校验
        
        //类型转换
        StudentPaperAnswer studentPaperAnswer = new StudentPaperAnswer();
        BeanUtils.copyProperties(paramDto,studentPaperAnswer);
        return Result.flag(studentPaperAnswerService.saveOrUpdate(studentPaperAnswer));
    }

    /**
     * @description 批量新增/修改数据
     * @param paramDtoList DTO 实体对象
     * @return 新增/修改结果
     */
    @PostMapping("saveOrUpdateList")
    @ApiOperation("根据idList批量新增/更新学生试卷答案表")
    public Result<?> addStudentPaperAnswerList(@RequestBody List<StudentPaperAnswerDTO> paramDtoList) {
        //数据校验

        //类型转换
        List<StudentPaperAnswer> studentPaperAnswerList = Convert.convert(new TypeReference<List<StudentPaperAnswer>>(){}, paramDtoList);
        boolean flag = studentPaperAnswerService.saveOrUpdateBatch(studentPaperAnswerList);
        System.out.println("studentPaperAnswerList = " + studentPaperAnswerList);
        return Result.success(studentPaperAnswerList);
    }
    
    /**
     * @description 删除单条数据
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @ApiOperation("根据id删除学生试卷答案表数据")
    public Result<?> deleteById(@PathVariable("id") Long id) {
        StudentPaperAnswer studentPaperAnswer = new StudentPaperAnswer();
        studentPaperAnswer.setId(id);
        return Result.flag(studentPaperAnswerService.removeById(studentPaperAnswer));
    }
    
    /**
     * @description 批量删除数据
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除学生试卷答案表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        List<StudentPaperAnswer> studentPaperAnswerList = studentPaperAnswerService.listByIds(idList);
        return Result.flag(studentPaperAnswerService.removeBatchByIds(studentPaperAnswerList));
    }
}