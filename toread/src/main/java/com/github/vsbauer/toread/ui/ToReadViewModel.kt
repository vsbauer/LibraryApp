package com.github.vsbauer.toread.ui

import androidx.lifecycle.ViewModel
import com.github.vsbauer.toread.ToReadRepository
import javax.inject.Inject

class ToReadViewModel @Inject constructor(repository: ToReadRepository) : ViewModel()