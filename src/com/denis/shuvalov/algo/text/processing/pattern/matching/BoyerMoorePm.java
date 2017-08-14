package com.denis.shuvalov.algo.text.processing.pattern.matching;

/**
 * At first, it might seem that it is always necessary to examine every character in the
 * text in order to locate a pattern as a substring or to rule out its existence. But this is
 * not always the case. The Boyer-Moore pattern-matching algorithm, which we will
 * study in this section, can sometimes avoid examining a significant fraction of the
 * character in the text.
 */
public class BoyerMoorePm {

/*
    Looking-Glass Heuristic: When testing a possible placement of the pattern against
    the text, perform the comparisons against the pattern from right-to-left.

    Character-Jump Heuristic: During the testing of a possible placement of the pattern
    within the text, a mismatch of character text[i]=c with the corresponding
    character pattern[k] is handled as follows. If c is not contained anywhere in
    the pattern, then shift the pattern completely past text[i] = c. Otherwise,
    shift the pattern until an occurrence of character c gets aligned with text[i].*/
}
