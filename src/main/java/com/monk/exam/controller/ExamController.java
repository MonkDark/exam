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
import com.monk.exam.entity.Exam;
import com.monk.exam.service.ExamService;
import com.monk.exam.dto.ExamDTO;
import com.monk.exam.vo.ExamVO;
import com.monk.exam.common.Result;
import javax.annotation.Resource;
import java.util.List;

/**
 * exam 表控制层
 * 考试表
 *
 * @author monk
 * @since 2022-04-28 15:01:58
 */
@Api(tags = "考试表")
@RestController
@RequestMapping("exam")
public class ExamController {
    /**
     * 服务对象
     */
    @Resource
    private ExamService examService;

    /**
     * @description 分页查询所有数据
     * @param paramDto DTO 查询实体
     * @return 所有数据
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按字段条件分页查询考试表")
    public Result<?> selectExamByCondition(@RequestBody ExamDTO paramDto) {
        //设置分页
        Page<Exam> examPage = new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize());
        //查询条件复制
        Exam exam = new Exam();
        BeanUtils.copyProperties(paramDto, exam);
        //查询结果类型转换
        examPage = examService.page(examPage, new QueryWrapper<>(exam));
        IPage<ExamVO> examVoPage = Convert.convert(new TypeReference<IPage<ExamVO>>(){}, examPage);
        return Result.success(examVoPage);
    }

    /**
     * @description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询考试表")
    public Result<?> selectById(@PathVariable("id") Long id) {
        ExamVO examVO = examService.getByIdMultiTable(id);
        return Result.success(examVO);
    }

    /**
     * @description 新增数据
     * @param paramDto DTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增考试表数据")
    public Result<?> addExam(@RequestBody ExamDTO paramDto) {
        return examService.saveMultiTable(paramDto);
    }
    
    
    /**
     * @description 修改数据
     * @param paramDto DTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("根据Id更新考试表")
    public Result<?> updateById(@RequestBody ExamDTO paramDto) {
        //数据校验
        
        //类型转换
        Exam exam = new Exam();
        BeanUtils.copyProperties(paramDto,exam);
        return Result.flag(examService.updateById(exam));
    }
    
    /**
     * @description 批量修改数据
     * @param paramDtoList DTO 实体对象
     * @return 修改结果
     */
    @PutMapping("updateList")
    @ApiOperation("根据idList批量更新考试表")
    public Result<?> updateExamList(@RequestBody List<ExamDTO> paramDtoList) {
        //数据校验
        
        //类型转换
        List<Exam> examList = Convert.convert(new TypeReference<List<Exam>>(){}, paramDtoList);
        return Result.flag(examService.updateBatchById(examList));
    }
    
    /**
     * @description 删除单条数据
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @ApiOperation("根据id删除考试表数据")
    public Result<?> deleteById(@PathVariable("id") Long id) {
        Exam exam = new Exam();
        exam.setId(id);
        return Result.flag(examService.removeById(exam));
    }
    
    /**
     * @description 批量删除数据
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除考试表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        List<Exam> examList = examService.listByIds(idList);
        return Result.flag(examService.removeBatchByIds(examList));
    }
}