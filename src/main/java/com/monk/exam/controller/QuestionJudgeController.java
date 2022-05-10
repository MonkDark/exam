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
import com.monk.exam.entity.QuestionJudge;
import com.monk.exam.service.QuestionJudgeService;
import com.monk.exam.dto.QuestionJudgeDTO;
import com.monk.exam.vo.QuestionJudgeVO;
import com.monk.exam.common.Result;
import javax.annotation.Resource;
import java.util.List;

/**
 * question_judge 表控制层
 * 判断题表
 *
 * @author monk
 * @since 2022-04-26 16:48:35
 */
@Api(tags = "判断题表")
@RestController
@RequestMapping("questionJudge")
public class QuestionJudgeController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionJudgeService questionJudgeService;

    /**
     * @description 分页查询所有数据
     *
     * @param paramDto DTO 查询实体
     * @return 所有数据
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按字段条件分页查询判断题表")
    public Result<?> selectQuestionJudgeByCondition(@RequestBody QuestionJudgeDTO paramDto) {
        //设置分页
        Page<QuestionJudge> questionJudgePage = new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize());
        //查询条件复制
        QuestionJudge questionJudge = new QuestionJudge();
        BeanUtils.copyProperties(paramDto, questionJudge);
        //查询结果类型转换
        questionJudgePage = questionJudgeService.page(questionJudgePage, new QueryWrapper<>(questionJudge));
        IPage<QuestionJudgeVO> questionJudgeVoPage = Convert.convert(new TypeReference<IPage<QuestionJudgeVO>>(){}, questionJudgePage);
        return Result.success(questionJudgeVoPage);
    }

    /**
     * @description 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询判断题表")
    public Result<?> selectById(@PathVariable("id") Long id) {
        QuestionJudge questionJudge = questionJudgeService.getById(id);
        //查询结果类型转换
        QuestionJudgeVO questionJudgeVO = new QuestionJudgeVO();
        BeanUtils.copyProperties(questionJudge,questionJudgeVO);
        return Result.success(questionJudgeVO);
    }

    /**
     * @description 新增数据
     *
     * @param paramDto DTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增判断题表数据")
    public Result<?> addQuestionJudge(@RequestBody QuestionJudgeDTO paramDto) {
        //数据校验
        
        //类型转换
        QuestionJudge questionJudge = new QuestionJudge();
        BeanUtils.copyProperties(paramDto,questionJudge);
        return Result.success(questionJudgeService.save(questionJudge));
    }
    
    
    /**
     * @description 修改数据
     *
     * @param paramDto DTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("根据Id更新判断题表")
    public Result<?> updateById(@RequestBody QuestionJudgeDTO paramDto) {
        //数据校验
        
        //类型转换
        QuestionJudge questionJudge = new QuestionJudge();
        BeanUtils.copyProperties(paramDto,questionJudge);
        return Result.success(questionJudgeService.updateById(questionJudge));
    }
    
    /**
     * @description 批量修改数据
     *
     * @param paramDtoList DTO 实体对象
     * @return 修改结果
     */
    @PutMapping("updateList")
    @ApiOperation("根据idList批量更新判断题表")
    public Result<?> updateQuestionJudgeList(@RequestBody List<QuestionJudgeDTO> paramDtoList) {
        //数据校验
        
        //类型转换
        List<QuestionJudge> questionJudgeList = Convert.convert(new TypeReference<List<QuestionJudge>>(){}, paramDtoList);
        return Result.success(questionJudgeService.updateBatchById(questionJudgeList));
    }
    
    /**
     * @description 删除单条数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @ApiOperation("根据id删除判断题表数据")
    public Result<?> deleteById(@PathVariable("id") Long id) {
        QuestionJudge questionJudge = new QuestionJudge();
        questionJudge.setId(id);
        return Result.success(questionJudgeService.removeById(questionJudge));
    }
    
    /**
     * @description 批量删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除判断题表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        List<QuestionJudge> questionJudgeList = questionJudgeService.listByIds(idList);
        return Result.success(questionJudgeService.removeBatchByIds(questionJudgeList));
    }
}