package br.com.tmovies.repositorie.helper.exception

import java.lang.Exception

class BusinessException(errorMessage: String?): Exception(errorMessage)