package com.monk.exam.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.monk.exam.entity.StudentExamScore;
import com.monk.exam.service.StudentExamScoreService;
import com.monk.exam.dto.StudentExamScoreDTO;
import com.monk.exam.vo.StudentExamScoreVO;
import com.monk.exam.common.Result;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * student_exam_score 表控制层
 * 学生考试成绩表
 *
 * @author monk
 * @since 2022-05-09 15:34:19
 */
@Api(tags = "学生考试成绩表")
@RestController
@RequestMapping("studentExamScore")
public class StudentExamScoreController {
    /**
     * 服务对象
     */
    @Resource
    private StudentExamScoreService studentExamScoreService;

    /**
     * @description 分页查询所有数据
     * @param paramDto DTO 查询实体
     * @return 所有数据
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按字段条件分页查询学生考试成绩表")
    public Result<?> selectStudentExamScoreByCondition(@RequestBody StudentExamScoreDTO paramDto) {
        //设置分页
        Page<StudentExamScore> studentExamScorePage = new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize());
        //查询条件复制
        StudentExamScore studentExamScore = paramDto.convertToStudentExamScore();
        //查询结果类型转换
        studentExamScorePage = studentExamScoreService.page(studentExamScorePage, new QueryWrapper<>(studentExamScore));
        IPage<StudentExamScoreVO> studentExamScoreVoPage = Convert.convert(new TypeReference<IPage<StudentExamScoreVO>>(){}, studentExamScorePage);
        return Result.success(studentExamScoreVoPage);
    }

    /**
     * @description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询学生考试成绩表")
    public Result<?> selectById(@PathVariable("id") Long id) {
        StudentExamScore studentExamScore = studentExamScoreService.getById(id);
        //查询结果类型转换
        StudentExamScoreVO studentExamScoreVO = new StudentExamScoreVO();
        BeanUtils.copyProperties(studentExamScore,studentExamScoreVO);
        return Result.success(studentExamScoreVO);
    }

    /**
     * @description 新增数据
     * @param paramDto DTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增学生考试成绩表数据")
    public Result<?> addStudentExamScore(@RequestBody StudentExamScoreDTO paramDto) {
        //数据校验
        
        //类型转换
        StudentExamScore studentExamScore = paramDto.convertToStudentExamScore().setExamTime(LocalDateTime.now());
        return Result.flag(studentExamScoreService.save(studentExamScore));
    }
    
    
    /**
     * @description 修改数据
     * @param paramDto DTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("根据Id更新学生考试成绩表")
    public Result<?> updateById(@RequestBody StudentExamScoreDTO paramDto) {
        //数据校验
        
        //类型转换
        StudentExamScore studentExamScore = paramDto.convertToStudentExamScore();
        return Result.flag(studentExamScoreService.updateById(studentExamScore));
    }
    
    /**
     * @description 批量修改数据
     * @param paramDtoList DTO 实体对象
     * @return 修改结果
     */
    @PutMapping("updateList")
    @ApiOperation("根据idList批量更新学生考试成绩表")
    public Result<?> updateStudentExamScoreList(@RequestBody List<StudentExamScoreDTO> paramDtoList) {
        //数据校验
        
        //类型转换
        List<StudentExamScore> studentExamScoreList = Convert.convert(new TypeReference<List<StudentExamScore>>(){}, paramDtoList);
        return Result.flag(studentExamScoreService.updateBatchById(studentExamScoreList));
    }
    
    /**
     * @description 删除单条数据
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @ApiOperation("根据id删除学生考试成绩表数据")
    public Result<?> deleteById(@PathVariable("id") Long id) {
        StudentExamScore studentExamScore = new StudentExamScore().setId(id);
        return Result.flag(studentExamScoreService.removeById(studentExamScore));
    }
    
    /**
     * @description 批量删除数据
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除学生考试成绩表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        List<StudentExamScore> studentExamScoreList = studentExamScoreService.listByIds(idList);
        return Result.flag(studentExamScoreService.removeBatchByIds(studentExamScoreList));
    }
}