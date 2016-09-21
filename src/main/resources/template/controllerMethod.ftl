    /**
     * 
     * @Description: ${method.todo}
     * @date:  ${createdTime}
     * @author ${user}
     * @param req
     * @return 
     * @throws
     */
    @ApiOperation(value = "${method.todo}", notes = "${method.todo}")
    @RequestMapping(value = "/${method.methodName}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ${method.returnResName} ${method.methodName}(@ModelAttribute ${method.methodReqName} req) throws Exception {
        

            return new ${method.returnResName}();
    }