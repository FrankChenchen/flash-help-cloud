package com.hqu.account;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;

public class MybatisGen {
    public static void main(String[] args) {


        FastAutoGenerator.create(new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/flash_help", "root", "518985599."))
                .globalConfig(builder -> {
                    // 生成的路径配置
                    File file = new File("flash-account");
                    builder.outputDir(file.getAbsolutePath() + "/src/main/java")
                            .author("起凡");
                })
                .packageConfig(builder -> {
                    // 生成的包配置
                    builder.parent("com.hqu.account")
                            .controller("controller")
                            .entity("entity")
                            .mapper("dao")
                            .xml("mapper")
                            .service("service");
                })
                .strategyConfig(builder -> {
                    // 要生成的表
                    builder.addInclude("sys_user", "sys_role", "sys_user_role").addTablePrefix("sys_");
                    // 生成的controller文件配置
                    builder.controllerBuilder().enableRestStyle().enableHyphenStyle();
                    // 生成的entity文件配置
                    builder.entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)
                            .logicDeleteColumnName("deleted")
                            .enableLombok()
                            .enableChainModel();
                    // 生成的mapper配置
                    builder.mapperBuilder().enableBaseResultMap();
                }).execute();
    }
}
