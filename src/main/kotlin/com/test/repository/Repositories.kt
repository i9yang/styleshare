package com.test.repository

import com.test.dto.Program
import com.test.dto.Region
import org.springframework.data.repository.CrudRepository

interface RegionRepository : CrudRepository<Region, String>
interface ProgramRepository : CrudRepository<Program, String>